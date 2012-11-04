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

package org.brekka.stillingar.spring.config;

import org.brekka.stillingar.api.ConfigurationException;
import org.brekka.stillingar.spring.bpp.ConfigurationBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Annotation config (external)
 *
 * @author Andrew Taylor (andrew@brekka.org)
 */
class AnnotationConfigBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser#doParse(org.w3c.dom.Element, org.springframework.beans.factory.xml.ParserContext, org.springframework.beans.factory.support.BeanDefinitionBuilder)
     */
    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String serviceRef = element.getAttribute("service-ref");
        builder.addConstructorArgReference(serviceRef);
        String marker = element.getAttribute("marker");
        if (StringUtils.hasLength(marker)) {
            Class<?> theClass = ClassUtils.resolveClassName(marker, Thread.currentThread().getContextClassLoader());
            if (!theClass.isAnnotation()) {
                throw new ConfigurationException(String.format("The class '%s' is not an annotation", marker));
            }
            builder.addPropertyValue("markerAnnotation", theClass);
        }
    }
    
    @Override
    protected boolean shouldGenerateId() {
        return true;
    }
    
    /* (non-Javadoc)
     * @see org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser#getBeanClass(org.w3c.dom.Element)
     */
    @Override
    protected Class<?> getBeanClass(Element element) {
        return ConfigurationBeanPostProcessor.class;
    }
}
