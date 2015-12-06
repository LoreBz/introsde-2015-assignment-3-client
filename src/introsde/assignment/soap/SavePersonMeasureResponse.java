
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per savePersonMeasureResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="savePersonMeasureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LifeStatus" type="{http://soap.assignment.introsde/}lifeStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "savePersonMeasureResponse", propOrder = {
    "lifeStatus"
})
public class SavePersonMeasureResponse {

    @XmlElement(name = "LifeStatus")
    protected LifeStatus lifeStatus;

    /**
     * Recupera il valore della proprietà lifeStatus.
     * 
     * @return
     *     possible object is
     *     {@link LifeStatus }
     *     
     */
    public LifeStatus getLifeStatus() {
        return lifeStatus;
    }

    /**
     * Imposta il valore della proprietà lifeStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link LifeStatus }
     *     
     */
    public void setLifeStatus(LifeStatus value) {
        this.lifeStatus = value;
    }

}
