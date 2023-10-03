package com.bignerdranch.android.criminalintent

import org.junit.runner.manipulation.Ordering

class CrimeRepository private constructor(context: Ordering.Context) {
    companion object {
        private var INSTANCE: CrimeRepository? = null
        fun initialize(context: CriminalIntentApplication.CriminalIntentApplication) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }
        fun get(): CrimeRepository {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        } }
}