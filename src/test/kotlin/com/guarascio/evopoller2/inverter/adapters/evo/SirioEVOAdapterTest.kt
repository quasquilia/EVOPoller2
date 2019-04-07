package com.guarascio.evopoller2.inverter.adapters.evo

import org.junit.Assert.*
import org.junit.Test
import java.io.InputStream

class SirioEVOAdapterTest {

    class Constants {
        companion object {
            const val PRECISION = 10e-6
        }
    }

    @Test
    fun contextLoads() {
        val pageStream: InputStream? = SirioEVOAdapterTest::class.java.getResourceAsStream("SirioEVOPage.htm")
        var sut = SirioEVOAdapter.PageParser(pageStream!!)

        val sample = sut.processPage()

        assertEquals(968.0, sample.power, Constants.PRECISION)
    }
}