package com.example.shedlocktest

import mu.KotlinLogging
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TestScheduler {
    private val logger = KotlinLogging.logger { }

    @Scheduled(fixedDelay = 10000)
    @SchedulerLock(
        name = "runScheduledLock",
        lockAtLeastFor = "PT5S",
        lockAtMostFor = "PT5S"
    )
    fun runScheduledLock() {
        logger.info { "------------------------------" }
        logger.info { "안녕하세요 저는 8000 이에요" }
        logger.info { LocalDateTime.now().toString() }
        logger.info { "------------------------------" }
        Thread.sleep(5000)
    }
}
