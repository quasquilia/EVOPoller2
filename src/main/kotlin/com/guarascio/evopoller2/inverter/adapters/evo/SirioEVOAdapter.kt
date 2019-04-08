package com.guarascio.evopoller2.inverter.adapters.evo

import com.guarascio.evopoller2.inverter.domainobjects.InverterSample
import java.io.*
import java.net.URL
import java.util.regex.Pattern

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



    class PageParser(var inputStream: InputStream) {
        private val patternW = Pattern.compile("\"([^\"]*) W\"")
        private val patternKWH = Pattern.compile("\"([^\"]*) KWh\"")

        private var lineNumber: Int = 1

        var inverterSample = InverterSample(power = 0.0, energy = 0.0)
            get() = field

        fun processPage(): InverterSample {
            BufferedReader(InputStreamReader(inputStream))
                    .lines()
                    .forEach(this::consumeLine)

            return inverterSample
        }

        private fun consumeLine(line: String) {
            if (lineNumber == 368) {
                //Logger.info(line);
                val matcher = patternW.matcher(line)
                if (matcher.find()) {
                    inverterSample.power = java.lang.Double.parseDouble(matcher.group(1))
                }
            } else if (lineNumber == 209) {
                val matcher = patternKWH.matcher(line)
                if (matcher.find()) {
                    inverterSample.energy = java.lang.Double.parseDouble(matcher.group(1).trim { it <= ' ' })
                }
            }
            lineNumber++
        }
    }
}