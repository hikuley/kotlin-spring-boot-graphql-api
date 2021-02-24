package com.kuleysoft.kotlinandspringbootgraphqlapi


import com.kuleysoft.generated.types.Actor
import com.kuleysoft.generated.types.Show
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData

@DgsComponent
class ShowsDataFetcher {

    private val shows = listOf(
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Halil"), Actor("Halil"), Actor("Halil"))),
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Halil"), Actor("Halil"), Actor("Halil"))),
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Halil"), Actor("Halil"), Actor("Halil"))),
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Halil"), Actor("Halil"), Actor("Halil"))),
            Show("Stranger Things", listOf(Actor("Halil"), Actor("Halil"), Actor("Halil"), Actor("Halil"))),
    )

    @DgsData(parentType = "Query", field = "shows")
    fun shows(): List<Show> {
        return this.shows
    }

}
