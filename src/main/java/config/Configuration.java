package config;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "configuration")
public class Configuration {

    @XmlElement(name = "BackendConfig")
    public BackendConfig backendConfig;

    @XmlElement(name = "FrontendConfig")
    public FrontendConfig frontendConfig;
}
