/*
 * Copyright 2011 the original author or authors.
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

package org.brekka.stillingar.core;

import org.brekka.stillingar.api.ConfigurationSource;


/**
 * Called when one or more values within a group are updated.
 * 
 * @author Andrew Taylor
 */
public interface GroupChangeListener {
    
    /**
     * The configuration of the group has changed.
     * 
     * @param the source that can be used to lookup additional values if necessary.
     */
	void onChange(ConfigurationSource configurationSource);
}
