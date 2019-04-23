/*
 * Copyright 2019 Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.microprofile.rest.client.tck.interfaces.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 18/04/2019
 */
public class ConfigurableHostnameVerifier implements HostnameVerifier {

    private static SSLSession sslSession;
    private static String hostname;
    private static boolean accepting = false;

    @Override
    public boolean verify(String hostname, SSLSession sslSession) {
        ConfigurableHostnameVerifier.sslSession = sslSession;
        ConfigurableHostnameVerifier.hostname = hostname;
        return accepting;
    }

    public static void setAccepting(boolean accepting) {
        ConfigurableHostnameVerifier.accepting = accepting;
    }

    public static SSLSession getSslSession() {
        return sslSession;
    }

    public static String getHostname() {
        return hostname;
    }
}
