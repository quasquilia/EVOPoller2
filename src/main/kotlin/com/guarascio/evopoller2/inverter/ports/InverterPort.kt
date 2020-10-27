package com.guarascio.evopoller2.inverter.ports

import com.guarascio.evopoller2.inverter.domainobjects.InverterSample

interface InverterPort {
    fun loadSample(): InverterSample?
}