
package com.muni.fi.pa165.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "monsterManagerupdate", namespace = "http://ws.pa165.fi.muni.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "monsterManagerupdate", namespace = "http://ws.pa165.fi.muni.com/")
public class MonsterManagerupdate {

    @XmlElement(name = "arg0", namespace = "")
    private com.muni.fi.pa165.dto.MonsterDto arg0;

    /**
     * 
     * @return
     *     returns MonsterDto
     */
    public com.muni.fi.pa165.dto.MonsterDto getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.muni.fi.pa165.dto.MonsterDto arg0) {
        this.arg0 = arg0;
    }

}
