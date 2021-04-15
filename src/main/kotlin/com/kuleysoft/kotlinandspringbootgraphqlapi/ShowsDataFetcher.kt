package com.kuleysoft.kotlinandspringbootgraphqlapi


import com.kuleysoft.generated.types.Actor
import com.kuleysoft.generated.types.Show
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData

@DgsComponent
class ShowsDataFetcher {

    private val shows = listOf(
            Show("Stranger Thingss", listOf(Actor("Halil"), Actor("Mahmut"), Actor("50cent"), Actor("Teoman"))),
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Mahmut"), Actor("50cent"), Actor("Teoman"))),
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Mahmut"), Actor("50cent"), Actor("Teoman"))),
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Mahmut"), Actor("50cent"), Actor("Teoman"))),
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Mahmut"), Actor("50cent"), Actor("Teoman"))),
    )

    @DgsData(parentType = "Query", field = "shows")
    fun shows(): List<Show> {
        return this.shows
    }

}
