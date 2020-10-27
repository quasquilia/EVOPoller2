package com.guarascio.evopoller2.inverter.adapters.evo

import com.guarascio.evopoller2.inverter.domainobjects.InverterSample
import com.guarascio.evopoller2.inverter.ports.InverterPort
import org.springframework.context.annotation.Bean
import java.io.*
import java.io.InputStreamReader
import java.io.BufferedReader
import java.net.*


class SirioEVOAdapter(var sirioInverterURL: String) : InverterPort {

    override fun loadSample(): InverterSample? {

        var params = (URLEncoder.encode("param1", "UTF-8")
                + "=" + URLEncoder.encode("value1", "UTF-8"))
        params += ("&" + URLEncoder.encode("param2", "UTF-8")
                + "=" + URLEncoder.encode("value2", "UTF-8"))

        val port = 80

        val addr = InetAddress.getByName(sirioInverterURL)
        val socket = Socket(addr, port)
        val path = "/"

        // Send headers
        val out = OutputStreamWriter(socket.getOutputStream(), "UTF8")
        val wr = BufferedWriter(out)
        wr.write("GET $path HTTP/1.0rn")
        wr.write("Content-Length: " + params.length + "rn")
        wr.write("Content-Type: application/x-www-form-urlencodedrn")
        wr.write("rn")

        // Send parameters
        val inputStream: InputStream?
        try {
            wr.write(params)
            wr.flush()
            inputStream = socket.getInputStream()
            return PageParser(inputStream).processPage()
        } catch (e: Exception) {
            println("${e.message} at ${sirioInverterURL}")
        } finally {
            wr.close()
        }
        return null
    }
}