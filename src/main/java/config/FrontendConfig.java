package config;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class FrontendConfig {

    @XmlElement(name = "LocalBrowser")
    public String localBrowser;
    @XmlElement(name = "Url")
    public String url;
    @XmlElement(name = "Headless")
    public Boolean headless;
    @XmlElement(name = "Gpu")
    public String gpu;
    @XmlElement(name = "InfoBars")
    public String infoBars;
    @XmlElement(name = "Sandbox")
    public String sandbox;
    @XmlElement(name = "RemoteURL")
    public String remoteUrl;
    @XmlElement(name = "ImplicitWait")
    public Integer implicitWait;
    @XmlElement(name = "ScriptTimeout")
    public Integer scriptTimeout;
    @XmlElement(name = "PageLoadTimeout")
    public Integer pageLoadTimeout;

}
