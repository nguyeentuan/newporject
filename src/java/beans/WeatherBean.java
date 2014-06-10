/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;
import ws.Weather;
import ws.WeatherWS_Service;

/**
 *
 * @author Hung
 */
@ManagedBean
@RequestScoped
public class WeatherBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/weatherSV/WeatherWS.wsdl")
    private WeatherWS_Service service;
    
    
    private List<ws.Weather> weathers;
    private String code;
    private Weather weather;

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    
    public List<ws.Weather> getWeathers() {
        weathers = getAll();
        return weathers;
    }

    public void setWeathers(List<ws.Weather> weathers) {
        this.weathers = weathers;
    }
    
    public String search(){
         weather= getWeatherByCode(code);
        return "result";
    }
    
    /**
     * Creates a new instance of WeatherBean
     */
    public WeatherBean() {
    }

    private java.util.List<ws.Weather> getAll() {
        ws.WeatherWS port = service.getWeatherWSPort();
        return port.getAll();
    }

    private ws.Weather getWeatherByCode(java.lang.String arg0) {
        ws.WeatherWS port = service.getWeatherWSPort();
        return port.getWeatherByCode(arg0);
    }
   
}
