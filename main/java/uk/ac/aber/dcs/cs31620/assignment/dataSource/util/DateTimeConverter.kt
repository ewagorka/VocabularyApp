package uk.ac.aber.dcs.cs31620.assignment.dataSource.util



import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

object DateTimeConverter {

    @TypeConverter
    @JvmStatic
    fun toLocalDate(timestamp: Long): LocalDateTime = LocalDateTime.ofInstant(
        Instant.ofEpochMilli(timestamp),
        TimeZone.getDefault().toZoneId()
    )

    @TypeConverter
    @JvmStatic
    fun toTimestamp(locaDateTime: LocalDateTime): Long =
        locaDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
}