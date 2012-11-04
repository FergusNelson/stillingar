/*
 * Copyright 2012 the original author or authors.
 *
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
 */

package org.brekka.stillingar.example.support;

import org.brekka.stillingar.api.annotations.ConfigurationListener;
import org.brekka.stillingar.api.annotations.Configured;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

@Configured
public class ApplicationContextBean implements InitializingBean  {
    
    private ApplicationContext applicationContext;
    
    
    public ApplicationContext getContext() {
        return applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
    
    @ConfigurationListener
    public void configure(@Configured("/c:Configuration/c:ApplicationContext/beans:beans") 
                             ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}