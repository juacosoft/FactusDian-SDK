package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusGetInvoiceResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: FactusGetInvoiceData
)

data class FactusGetInvoiceData(
    @SerializedName("company") val company: FactusGetInvoiceCompany,
    @SerializedName("customer") val customer: FactusGetInvoiceCustomer,
    @SerializedName("numbering_range") val numberingRange: FactusGetInvoiceNumberingRange,
    @SerializedName("billing_period") val billingPeriod: List<Any>?,
    @SerializedName("bill") val bill: FactusGetInvoiceBill,
    @SerializedName("related_documents") val relatedDocuments: List<Any>?,
    @SerializedName("items") val items: List<FactusGetInvoiceItem>,
    @SerializedName("withholding_taxes") val withholdingTaxes: List<FactusGetInvoiceWithholdingTax>,
    @SerializedName("credit_notes") val creditNotes: List<Any>?,
    @SerializedName("debit_notes") val debitNotes: List<Any>?
)

data class FactusGetInvoiceCompany(
    @SerializedName("url_logo") val urlLogo: String,
    @SerializedName("nit") val nit: String,
    @SerializedName("dv") val dv: String?,
    @SerializedName("company") val company: String,
    @SerializedName("name") val name: String,
    @SerializedName("graphic_representation_name") val graphicRepresentationName: String,
    @SerializedName("registration_code") val registrationCode: String,
    @SerializedName("economic_activity") val economicActivity: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("email") val email: String,
    @SerializedName("direction") val direction: String,
    @SerializedName("municipality") val municipality: String
)

data class FactusGetInvoiceCustomer(
    @SerializedName("identification") val identification: String,
    @SerializedName("dv") val dv: String?,
    @SerializedName("graphic_representation_name") val graphicRepresentationName: String,
    @SerializedName("trade_name") val tradeName: String,
    @SerializedName("company") val company: String,
    @SerializedName("names") val names: String,
    @SerializedName("address") val address: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("legal_organization") val legalOrganization: FactusGetInvoiceLegalOrganization,
    @SerializedName("tribute") val tribute: FactusGetInvoiceTribute,
    @SerializedName("municipality") val municipality: FactusGetInvoiceMunicipality
)

data class FactusGetInvoiceLegalOrganization(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoiceTribute(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoiceMunicipality(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoiceNumberingRange(
    @SerializedName("prefix") val prefix: String,
    @SerializedName("from") val from: Long,
    @SerializedName("to") val to: Long,
    @SerializedName("resolution_number") val resolutionNumber: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("end_date") val endDate: String,
    @SerializedName("months") val months: Int
)

data class FactusGetInvoiceBill(
    @SerializedName("id") val id: Int,
    @SerializedName("document") val document: FactusGetInvoiceDocument,
    @SerializedName("number") val number: String,
    @SerializedName("reference_code") val referenceCode: String?,
    @SerializedName("status") val status: Int,
    @SerializedName("send_email") val sendEmail: Int,
    @SerializedName("qr") val qr: String,
    @SerializedName("cufe") val cufe: String,
    @SerializedName("validated") val validated: String,
    @SerializedName("discount_rate") val discountRate: String,
    @SerializedName("discount") val discount: String,
    @SerializedName("gross_value") val grossValue: String,
    @SerializedName("taxable_amount") val taxableAmount: String,
    @SerializedName("tax_amount") val taxAmount: String,
    @SerializedName("total") val total: String,
    @SerializedName("observation") val observation: String,
    @SerializedName("errors") val errors: List<Any>,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("payment_due_date") val paymentDueDate: String?,
    @SerializedName("qr_image") val qrImage: String,
    @SerializedName("has_claim") val hasClaim: Int,
    @SerializedName("is_negotiable_instrument") val isNegotiableInstrument: Int,
    @SerializedName("payment_form") val paymentForm: FactusGetInvoicePaymentForm,
    @SerializedName("payment_method") val paymentMethod: FactusGetInvoicePaymentMethod
)

data class FactusGetInvoiceDocument(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoicePaymentForm(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoicePaymentMethod(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoiceItem(
    @SerializedName("code_reference") val codeReference: String,
    @SerializedName("name") val name: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("discount_rate") val discountRate: String,
    @SerializedName("discount") val discount: String,
    @SerializedName("gross_value") val grossValue: String,
    @SerializedName("tax_rate") val taxRate: String,
    @SerializedName("taxable_amount") val taxableAmount: String,
    @SerializedName("tax_amount") val taxAmount: String,
    @SerializedName("price") val price: String,
    @SerializedName("is_excluded") val isExcluded: Int,
    @SerializedName("unit_measure") val unitMeasure: FactusGetInvoiceUnitMeasure,
    @SerializedName("standard_code") val standardCode: FactusGetInvoiceStandardCode,
    @SerializedName("tribute") val tribute: FactusGetInvoiceTribute,
    @SerializedName("total") val total: Int,
    @SerializedName("withholding_taxes") val withholdingTaxes: List<FactusGetInvoiceWithholdingTax>
)

data class FactusGetInvoiceUnitMeasure(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoiceStandardCode(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusGetInvoiceWithholdingTax(
    @SerializedName("tribute_code") val tributeCode: String,
    @SerializedName("name") val name: String,
    @SerializedName("value") val value: String,
    @SerializedName("rates") val rates: List<FactusGetInvoiceRate> = emptyList()
)

data class FactusGetInvoiceRate(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("rate") val rate: String
)
