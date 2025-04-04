/*-
 * ========================LICENSE_START=================================
 * flyway-maven-plugin
 * ========================================================================
 * Copyright (C) 2010 - 2025 Red Gate Software Ltd
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package org.flywaydb.maven;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.flywaydb.core.Flyway;

/**
 * Repairs the Flyway schema history table. This will perform the following actions:
 * <ul>
 * <li>Remove any failed migrations on databases without DDL transactions (User objects left behind must still be cleaned up manually)</li>
 * <li>Realign the checksums, descriptions and types of the applied migrations with the ones of the available migrations</li>
 * </ul>
 */
@SuppressWarnings({"UnusedDeclaration", "JavaDoc"})
@Mojo(name = "repair",
        requiresDependencyResolution = ResolutionScope.TEST,
        defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST,
        threadSafe = true)
public class RepairMojo extends AbstractFlywayMojo {
    @Override
    protected void doExecute(Flyway flyway) {
        flyway.repair();
    }
}
