
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per updatePersonMeasure complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="updatePersonMeasure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="lifestatus" type="{http://soap.assignment.introsde/}healthMeasureHistory" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePersonMeasure", propOrder = {
    "personId",
    "lifestatus"
})
public class UpdatePersonMeasure {

    protected Long personId;
    protected HealthMeasureHistory lifestatus;

    /**
     * Recupera il valore della proprietà personId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * Imposta il valore della proprietà personId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPersonId(Long value) {
        this.personId = value;
    }

    /**
     * Recupera il valore della proprietà lifestatus.
     * 
     * @return
     *     possible object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public HealthMeasureHistory getLifestatus() {
        return lifestatus;
    }

    /**
     * Imposta il valore della proprietà lifestatus.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthMeasureHistory }
     *     
     */
    public void setLifestatus(HealthMeasureHistory value) {
        this.lifestatus = value;
    }

}
