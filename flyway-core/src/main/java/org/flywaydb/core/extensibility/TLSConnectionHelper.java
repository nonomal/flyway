/*-
 * ========================LICENSE_START=================================
 * flyway-core
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
package org.flywaydb.core.extensibility;

import java.util.List;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.experimental.ConnectionType;
import org.flywaydb.core.experimental.ExperimentalDatabase;

public interface TLSConnectionHelper extends Plugin{
    String SSL_AUTOCONFIGURATION_ENV = "FLYWAY_SSL_AUTOCONFIGURATION";

    static List<TLSConnectionHelper> get(Configuration configuration) {
        return configuration.getPluginRegister()
            .getPlugins(TLSConnectionHelper.class)
            .stream().toList();
    }

    void prepareForTLSConnection(String connectionString, ConnectionType connectionType, ExperimentalDatabase database, Configuration configuration);

}
