/*
* Project Name: xinyunlian-ecom
* File Name: JaxbUtils.java
* Class Name: JaxbUtils
*
* Copyright 2014 Hengtian Software Inc
*
* Licensed under the Hengtiansoft
*
* http://www.hengtiansoft.com
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
* implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.doris.soap;

import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author yupengshen
 *
 */
public class JaxbUtils {

    //private static final Logger                         LOGGER  = LoggerFactory.getLogger(StringEscapeUtils.class);

    private static ConcurrentMap<Class<?>, JAXBContext> jaxbMap = new ConcurrentHashMap<Class<?>, JAXBContext>();
    
    public static final String JAXB_ENCODING = "jaxb.encoding";
    
    /**  过滤头信�?*/
    public static final String JAXB_FRAGMENT ="jaxb.fragment";
    
    
   

    /**
     * @param xml
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromXml(String xml, Class<T> clazz) {
        try {
            StringReader reader = new StringReader(xml);
            return (T) createUnmarshaller(clazz).unmarshal(reader);
        } catch (JAXBException e) {
            // LOGGER.error("Error occured when parsing to object.", e);
            throw new RuntimeException(e);
        }
    }

    public static String toXml(Object root, String encoding) {
        try {
            StringWriter writer = new StringWriter();
            Map<String,Object> settings = new HashMap<String, Object>();
            settings.put(JAXB_ENCODING, encoding);
            createMarshaller(root.getClass(), settings).marshal(root, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toXml(Object root, String encoding, boolean jaxbFragment) {
        try {
            StringWriter writer = new StringWriter();
            Map<String, Object> settings = new HashMap<String, Object>();
            settings.put(JAXB_ENCODING, encoding);
            settings.put(JAXB_FRAGMENT, jaxbFragment);
            createMarshaller(root.getClass(), settings).marshal(root, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static void toXml(Object root, OutputStream output, String encoding) {
        try {
            Map<String,Object> settings = new HashMap<String, Object>();
            settings.put(JAXB_ENCODING, encoding);
            createMarshaller(root.getClass(), settings).marshal(root, output);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param clazz
     * @param encoding
     * @return
     */
    public static Marshaller createMarshaller(Class<?> clazz, Map<String,Object> settings) {
        try {
            JAXBContext jaxbContext = getJaxbContext(clazz);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, (String)settings.get(JAXB_ENCODING));
//            if (StringUtils.isNotEmpty((String)settings.get(JAXB_ENCODING))) {
//                marshaller.setProperty(Marshaller.JAXB_ENCODING, (String)settings.get(JAXB_ENCODING));
//            }
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
//            if( null != settings.get(JAXB_FRAGMENT)){
//                marshaller.setProperty(Marshaller.JAXB_FRAGMENT, (Boolean)settings.get(JAXB_FRAGMENT));
//            }
            return marshaller;
        } catch (JAXBException e) {
            // LOGGER.error("Error occured when creating marshaller.", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param clazz
     * @return
     */
    public static Unmarshaller createUnmarshaller(Class<?> clazz) {
        try {
            JAXBContext jaxbContext = getJaxbContext(clazz);
            return jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            // LOGGER.error("Error occured when creating Unmarshaller.", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param clazz
     * @return
     */
    private static JAXBContext getJaxbContext(Class<?> clazz) {
        JAXBContext jaxbContext = jaxbMap.get(clazz);
        if (jaxbContext == null) {
            try {
                jaxbContext = JAXBContext.newInstance(clazz);
                jaxbMap.putIfAbsent(clazz, jaxbContext);
            } catch (JAXBException ex) {
                throw new RuntimeException("Could not instantiate JAXBContext.", ex);
            }
        }
        return jaxbContext;
    }
    

}

