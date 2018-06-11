/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.valtech.au.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

@Model(adaptables=Resource.class)
public class HelloWorldModel {

    @Inject
    private SlingSettingsService settings;

    @Inject @Named("sling:resourceType") @Default(values="No resourceType")
    protected String resourceType;

    private String message;


    /**
     * Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not
     *
     * xyzThere("abcxyz") → true
     * xyzThere("abc.xyz") → false
     * xyzThere("xyz.abc") → true
     **/
    public boolean xyzThere(String str) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    @PostConstruct
    protected void init() {
        if (xyzThere("abc.xyzxyz")) {
            message = "Yes! Good Work!";
        } else {
          message = "Not yet. Try again";
        }
    }

    public String getMessage() {
        return message;
    }
}
