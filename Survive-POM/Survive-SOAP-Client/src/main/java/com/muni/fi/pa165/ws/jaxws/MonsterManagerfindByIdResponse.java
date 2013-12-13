
package com.muni.fi.pa165.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "monsterManagerfindByIdResponse", namespace = "http://ws.pa165.fi.muni.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "monsterManagerfindByIdResponse", namespace = "http://ws.pa165.fi.muni.com/")
public class MonsterManagerfindByIdResponse {

    @XmlElement(name = "return", namespace = "")
    private com.muni.fi.pa165.dto.MonsterDto _return;

    /**
     * 
     * @return
     *     returns MonsterDto
     */
    public com.muni.fi.pa165.dto.MonsterDto getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.muni.fi.pa165.dto.MonsterDto _return) {
        this._return = _return;
    }

}
