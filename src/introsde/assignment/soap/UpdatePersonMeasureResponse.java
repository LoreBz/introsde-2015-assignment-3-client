
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per updatePersonMeasureResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="updatePersonMeasureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HealthMeasureHistory" type="{http://soap.assignment.introsde/}healthMeasureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePersonMeasureResponse", propOrder = {
    "healthMeasureHistory"
})
public class UpdatePersonMeasureResponse {

    @XmlElement(name = "HealthMeasureHistory")
    protected HealthMeasureHistory healthMeasureHistory;

    /**
     * Recupera il valore della proprietà healthMeasureHistory.
     * 
     * @return
     *     possible object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public HealthMeasureHistory getHealthMeasureHistory() {
        return healthMeasureHistory;
    }

    /**
     * Imposta il valore della proprietà healthMeasureHistory.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public void setHealthMeasureHistory(HealthMeasureHistory value) {
        this.healthMeasureHistory = value;
    }

}
