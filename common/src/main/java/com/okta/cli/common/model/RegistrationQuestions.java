/*
 * Copyright 2018-Present Okta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.okta.cli.common.model;

public interface RegistrationQuestions {

    boolean isOverwriteExistingConfig(String oktaBaseUrl, String configFile);

    OrganizationRequest getOrganizationRequest();

    static RegistrationQuestions answers(boolean overwriteConfig, OrganizationRequest request) {
        return new SimpleRegistrationQuestions(overwriteConfig, request);
    }

    class SimpleRegistrationQuestions implements RegistrationQuestions {
        private final boolean overwriteConfig;
        private final OrganizationRequest organizationRequest;

        public SimpleRegistrationQuestions(boolean overwriteConfig, OrganizationRequest organizationRequest) {
            this.overwriteConfig = overwriteConfig;
            this.organizationRequest = organizationRequest;
        }

        public boolean isOverwriteExistingConfig(String oktaBaseUrl, String configFile) {
            return overwriteConfig;
        }

        public OrganizationRequest getOrganizationRequest() {
            return organizationRequest;
        }
    }
}
