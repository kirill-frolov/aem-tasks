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


    /** A palindrome is a word that reads the same backward or forward.
     *
     * Write a function that checks if a give word is a palindrome. Character case should be ignored.
     * For example, isPalindrome("Deleveled") should return true as character case should be ignored,
     * resulting in "deleveled", which is a palindrome since it reads the same backward and forward.
     **/
    public static boolean isPalindrome(String word) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    @PostConstruct
    protected void init() {
        if (isPalindrome("racecar")) {
            message = "Yes! Good Work!";
        } else {
          message = "Not yet. Try again";
        }
    }

    public String getMessage() {
        return message;
    }
}
