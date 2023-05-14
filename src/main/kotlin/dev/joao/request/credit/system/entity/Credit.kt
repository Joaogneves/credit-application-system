package dev.joao.request.credit.system.entity

import dev.joao.request.credit.system.enums.Status
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "credit")
data class Credit(
        @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
        @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
        @Column(nullable = false) val dayFirstInstallment: LocalDate,
        @Column(nullable = false) val numberOfInstallment: Int = 0,
        @Enumerated var status: Status = Status.IN_PROGRESS,
        @ManyToOne val customer: Customer? = null,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)