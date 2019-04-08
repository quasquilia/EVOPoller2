package com.guarascio.evopoller2.inverter.adapters.evo

import com.guarascio.evopoller2.inverter.domainobjects.InverterSample
import java.io.*
import java.net.URL

class SirioEVOAdapter(var sirioInverterURL: String) {

    fun performRequest(): InverterSample? {


        // configure the SSLContext with a TrustManager
        val url = URL(sirioInverterURL)

        //Logger.info("Opening page $url")
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