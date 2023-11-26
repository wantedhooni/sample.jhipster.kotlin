package com.revy.app.repository.timezone

import javax.persistence.*
import java.io.Serializable
import java.time.*

@Entity
@Table(name = "jhi_date_time_wrapper")
class DateTimeWrapper(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    var id: Long? = null,

    @Column(name = "instant")
    var instant: Instant? = null,

    @Column(name = "local_date_time")
    var localDateTime: LocalDateTime? = null,

    @Column(name = "offset_date_time")
    var offsetDateTime: OffsetDateTime? = null,

    @Column(name = "zoned_date_time")
    var zonedDateTime: ZonedDateTime? = null,

    @Column(name = "local_time")
    var localTime: LocalTime? = null,

    @Column(name = "offset_time")
    var offsetTime: OffsetTime? = null,

    @Column(name = "local_date")
    var localDate: LocalDate? = null

) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DateTimeWrapper) return false
        if (other.id == null || id == null) return false

        return id == other.id
    }

    override fun hashCode() = id.hashCode()

    override fun toString() = "TimeZoneTest{" +
        "id=" + id +
        ", instant=" + instant +
        ", localDateTime=" + localDateTime +
        ", offsetDateTime=" + offsetDateTime +
        ", zonedDateTime=" + zonedDateTime +
        '}'.toString()

    companion object {
        private const val serialVersionUID = 1L
    }
}
