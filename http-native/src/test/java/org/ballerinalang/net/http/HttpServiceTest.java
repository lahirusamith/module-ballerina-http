/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.net.http;

import io.ballerina.runtime.api.values.BObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * A unit test class for http module {@link HttpService} class functions.
 */
public class HttpServiceTest {

    @Test
    public void testKeepAlive() {
        BObject service = TestUtils.getNewServiceObject("hello");
        HttpService httpService = new HttpService(service);
        Assert.assertTrue(httpService.isKeepAlive());

        httpService.setKeepAlive(false);
        Assert.assertFalse(httpService.isKeepAlive());
    }

    @Test
    public void testNullServiceBasePath() {
        BObject service = TestUtils.getNewServiceObject("hello");
        HttpService httpService = new HttpService(service);
        httpService.setBasePath(null);

        Assert.assertEquals(httpService.getBasePath(), "/hello");

        service = TestUtils.getNewServiceObject("$hello");
        httpService = new HttpService(service);
        httpService.setBasePath(null);

        Assert.assertEquals(httpService.getBasePath(), "/");
    }

    @Test
    public void testEmptyNullServiceBasePath() {
        BObject service = TestUtils.getNewServiceObject("hello");
        HttpService httpService = new HttpService(service);
        httpService.setBasePath(" ");

        Assert.assertEquals(httpService.getBasePath(), "/hello");
    }

    @Test
    public void testNotNullServiceBasePath() {
        BObject service = TestUtils.getNewServiceObject("hello");
        HttpService httpService = new HttpService(service);
        httpService.setBasePath("ballerina");

        Assert.assertEquals(httpService.getBasePath(), "/ballerina");
    }
}
