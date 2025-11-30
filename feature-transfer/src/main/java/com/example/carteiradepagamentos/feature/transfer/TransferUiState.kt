package com.example.carteiradepagamentos.feature.transfer

import com.example.carteiradepagamentos.domain.model.Contact

data class TransferUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val successMessage: String? = null,
    val selectedContact: Contact? = null,
    val amountInput: String = "R$ 0,00",
    val amountInCents: Long = 0,
    val balanceText: String = "",
    val contacts: List<Contact> = emptyList()
)
