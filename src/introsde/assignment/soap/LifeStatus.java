
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per lifeStatus complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="lifeStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idMeasure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="measureDefinition" type="{http://soap.assignment.introsde/}measureDefinition" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lifeStatus", propOrder = {
    "idMeasure",
    "measureDefinition",
    "value"
})
public class LifeStatus {

    protected int idMeasure;
    protected MeasureDefinition measureDefinition;
    protected String value;

    /**
     * Recupera il valore della proprietÓ idMeasure.
     * 
     */
    public int getIdMeasure() {
        return idMeasure;
    }

    /**
     * Imposta il valore della proprietÓ idMeasure.
     * 
     */
    public void setIdMeasure(int value) {
        this.idMeasure = value;
    }

    /**
     * Recupera il valore della proprietÓ measureDefinition.
     * 
     * @return
     *     possible object is
     *     {@link MeasureDefinition }
     *     
     */
    public MeasureDefinition getMeasureDefinition() {
        return measureDefinition;
    }

    /**
     * Imposta il valore della proprietÓ measureDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureDefinition }
     *     
     */
    public void setMeasureDefinition(MeasureDefinition value) {
        this.measureDefinition = value;
    }

    /**
     * Recupera il valore della proprietÓ value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Imposta il valore della proprietÓ value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
