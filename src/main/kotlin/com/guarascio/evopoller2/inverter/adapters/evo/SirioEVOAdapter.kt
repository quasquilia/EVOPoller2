package com.guarascio.evopoller2.inverter.adapters.evo

import com.guarascio.evopoller2.inverter.domainobjects.InverterSample
import com.guarascio.evopoller2.inverter.ports.InverterPort
import java.io.*
import java.net.URL

class SirioEVOAdapter(var sirioInverterURL: String) : InverterPort {

    fun loadSample(): InverterSample? {

        val url = URL(sirioInverterURL)

        val conn = url.openConnection()
        var inputStream: InputStream? = null
        var result: InverterSample? = null
        try {
            inputStream = conn.getInputStream()
            result = PageParser(inputStream).processPage()
        } catch (e: Exception) {
            //Logger.error(e.message + " at " + address)
        } finally {
            inputStream?.close()
        }
        return result
    }
}