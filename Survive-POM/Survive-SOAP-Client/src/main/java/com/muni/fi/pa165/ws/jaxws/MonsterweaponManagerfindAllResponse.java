
package com.muni.fi.pa165.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "monsterweaponManagerfindAllResponse", namespace = "http://ws.pa165.fi.muni.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "monsterweaponManagerfindAllResponse", namespace = "http://ws.pa165.fi.muni.com/")
public class MonsterweaponManagerfindAllResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.muni.fi.pa165.dto.MonsterWeaponDto> _return;

    /**
     * 
     * @return
     *     returns List<MonsterWeaponDto>
     */
    public List<com.muni.fi.pa165.dto.MonsterWeaponDto> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.muni.fi.pa165.dto.MonsterWeaponDto> _return) {
        this._return = _return;
    }

}
