//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.16 at 09:26:00 PM MSK 
//


package model.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for exercise complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exercise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exercise_id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="user_id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="exercise_name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="exercise_set">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="exercise_reps">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="exercise_duration_mins">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="exercise_weight_kg">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}float">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exercise", propOrder = {
    "exerciseId",
    "userId",
    "exerciseName",
    "exerciseSet",
    "exerciseReps",
    "exerciseDurationMins",
    "exerciseWeightKg"
})
public class Exercise {

    public Exercise() {
    }

    public Exercise(int userId, String exerciseName, int exerciseSet, int exerciseReps, float exerciseDurationMins, float exerciseWeightKg) {
        this.userId = userId;
        this.exerciseName = exerciseName;
        this.exerciseSet = exerciseSet;
        this.exerciseReps = exerciseReps;
        this.exerciseDurationMins = exerciseDurationMins;
        this.exerciseWeightKg = exerciseWeightKg;
    }

    public Exercise(int exerciseId, int userId, String exerciseName, int exerciseSet, int exerciseReps, float exerciseDurationMins, float exerciseWeightKg) {
        this.exerciseId = exerciseId;
        this.userId = userId;
        this.exerciseName = exerciseName;
        this.exerciseSet = exerciseSet;
        this.exerciseReps = exerciseReps;
        this.exerciseDurationMins = exerciseDurationMins;
        this.exerciseWeightKg = exerciseWeightKg;
    }

    @XmlElement(name = "exercise_id")
    protected int exerciseId;
    @XmlElement(name = "user_id")
    protected int userId;
    @XmlElement(name = "exercise_name", required = true)
    protected String exerciseName;
    @XmlElement(name = "exercise_set")
    protected int exerciseSet;
    @XmlElement(name = "exercise_reps")
    protected int exerciseReps;
    @XmlElement(name = "exercise_duration_mins")
    protected float exerciseDurationMins;
    @XmlElement(name = "exercise_weight_kg")
    protected float exerciseWeightKg;

    /**
     * Gets the value of the exerciseId property.
     * 
     */
    public int getExerciseId() {
        return exerciseId;
    }

    /**
     * Sets the value of the exerciseId property.
     * 
     */
    public void setExerciseId(int value) {
        this.exerciseId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Gets the value of the exerciseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExerciseName() {
        return exerciseName;
    }

    /**
     * Sets the value of the exerciseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExerciseName(String value) {
        this.exerciseName = value;
    }

    /**
     * Gets the value of the exerciseSet property.
     * 
     */
    public int getExerciseSet() {
        return exerciseSet;
    }

    /**
     * Sets the value of the exerciseSet property.
     * 
     */
    public void setExerciseSet(int value) {
        this.exerciseSet = value;
    }

    /**
     * Gets the value of the exerciseReps property.
     * 
     */
    public int getExerciseReps() {
        return exerciseReps;
    }

    /**
     * Sets the value of the exerciseReps property.
     * 
     */
    public void setExerciseReps(int value) {
        this.exerciseReps = value;
    }

    /**
     * Gets the value of the exerciseDurationMins property.
     * 
     */
    public float getExerciseDurationMins() {
        return exerciseDurationMins;
    }

    /**
     * Sets the value of the exerciseDurationMins property.
     * 
     */
    public void setExerciseDurationMins(float value) {
        this.exerciseDurationMins = value;
    }

    /**
     * Gets the value of the exerciseWeightKg property.
     * 
     */
    public float getExerciseWeightKg() {
        return exerciseWeightKg;
    }

    /**
     * Sets the value of the exerciseWeightKg property.
     * 
     */
    public void setExerciseWeightKg(float value) {
        this.exerciseWeightKg = value;
    }

    @Override
    public String toString() {
        return "('"  + userId
                + "','" + exerciseName +
                "','" + exerciseSet +
                "','" + exerciseReps +
                "','" + exerciseDurationMins +
                "','" + exerciseWeightKg + "')";
    }
}
