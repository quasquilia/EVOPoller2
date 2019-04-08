package com.guarascio.evopoller2.inverter.adapters.evo

import org.junit.Assert.*
import org.junit.Test
import java.io.InputStream

class PageParserTest {

    class Constants {
        companion object {
            const val PRECISION = 10e-6
        }
    }

    @Test
    fun powerAndEnergyAreParsedFromHtmlPage() {
        val pageStream: InputStream? = PageParserTest::class.java.getResourceAsStream("/SirioEVOPage.htm")
        var sut = PageParser(pageStream!!)

        val sample = sut.processPage()

        assertEquals(968.0, sample.power, Constants.PRECISION)
        assertEquals(38040.6, sample.energy, Constants.PRECISION)

    }
}