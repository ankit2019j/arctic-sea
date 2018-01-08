/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.shetland.ogc.sos.response;

import org.n52.shetland.ogc.gml.AbstractFeature;
import org.n52.shetland.ogc.ows.service.OwsServiceResponse;
import org.n52.shetland.ogc.sos.SosConstants;

/**
 * @since 1.0.0
 *
 */
public class GetFeatureOfInterestResponse
        extends OwsServiceResponse {

    private AbstractFeature abstractFeature;

    public GetFeatureOfInterestResponse() {
        super(null, null, SosConstants.Operations.GetFeatureOfInterest.name());
    }

    public GetFeatureOfInterestResponse(String service, String version) {
        super(service, version, SosConstants.Operations.GetFeatureOfInterest.name());
    }

    public GetFeatureOfInterestResponse(String service, String version, String operationName) {
        super(service, version, operationName);
    }

    public GetFeatureOfInterestResponse(AbstractFeature abstractFeature) {
        this.abstractFeature = abstractFeature;
    }

    public GetFeatureOfInterestResponse(String service, String version, AbstractFeature abstractFeature) {
        this(service, version, SosConstants.Operations.GetFeatureOfInterest.name(), abstractFeature);
    }

    public GetFeatureOfInterestResponse(
            String service, String version, String operationName, AbstractFeature abstractFeature) {
        super(service, version, operationName);
        this.abstractFeature = abstractFeature;
    }

    public AbstractFeature getAbstractFeature() {
        return abstractFeature;
    }

    public void setAbstractFeature(AbstractFeature abstractFeature) {
        this.abstractFeature = abstractFeature;
    }

}