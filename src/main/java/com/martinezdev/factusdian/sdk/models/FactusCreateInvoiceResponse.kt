package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusCreateInvoiceResponse(
    @SerializedName("status") val status: String? = null,
    @SerializedName("message") val message: String? = null,
    @SerializedName("data") val data: FactusData? = FactusData()
)

data class FactusCompany(
    @SerializedName("url_logo") val urlLogo: String? = null,
    @SerializedName("nit") val nit: String? = null,
    @SerializedName("dv") val dv: String? = null,
    @SerializedName("company") val company: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("graphic_representation_name") val graphicRepresentationName: String? = null,
    @SerializedName("registration_code") val registrationCode: String? = null,
    @SerializedName("economic_activity") val economicActivity: String? = null,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("direction") val direction: String? = null,
    @SerializedName("municipality") val municipality: String? = null
)

data class FactusLegalOrganization(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("name") val name: String? = null
)

data class FactusTribute(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("name") val name: String? = null
)

data class FactusMunicipality(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("name") val name: String? = null
)

data class FactusData(
    @SerializedName("company") val company: FactusCompany? = FactusCompany(),
    @SerializedName("customer") val customer: FactusCustomer? = FactusCustomer(),
    @SerializedName("numbering_range") val numberingRange: FactusNumberingRange? = FactusNumberingRange(),
    @SerializedName("billing_period") val billingPeriod: BillingPeriod? = null,
    @SerializedName("bill") val bill: FactusBill? = FactusBill(),
    @SerializedName("related_documents") val relatedDocuments: ArrayList<String> = arrayListOf(),
    @SerializedName("items") val items: ArrayList<FactusItemsResponse> = arrayListOf(),
    @SerializedName("withholding_taxes") val withholdingTaxes: ArrayList<FactusWithholdingTaxes> = arrayListOf(),
    @SerializedName("credit_notes") val creditNotes: ArrayList<String> = arrayListOf(),
    @SerializedName("debit_notes") val debitNotes: ArrayList<String> = arrayListOf()
)

data class BillingPeriod(
    @SerializedName("start_date") val startDate: String? = null,
    @SerializedName("start_time") val startTime: String? = null,
    @SerializedName("end_date") val endDate: String? = null,
    @SerializedName("end_time") val endTime: String? = null
)

data class FactusNumberingRange(
    @SerializedName("prefix") val prefix: String? = null,
    @SerializedName("from") val from: Int? = null,
    @SerializedName("to") val to: Int? = null,
    @SerializedName("resolution_number") val resolutionNumber: String? = null,
    @SerializedName("start_date") val startDate: String? = null,
    @SerializedName("end_date") val endDate: String? = null,
    @SerializedName("months") val months: Int? = null
)

data class FactusBill(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("document") val document: FactusDocument? = FactusDocument(),
    @SerializedName("number") val number: String? = null,
    @SerializedName("reference_code") val referenceCode: String? = null,
    @SerializedName("status") val status: Int? = null,
    @SerializedName("send_email") val sendEmail: Int? = null,
    @SerializedName("qr") val qr: String? = null,
    @SerializedName("cufe") val cufe: String? = null,
    @SerializedName("validated") val validated: String? = null,
    @SerializedName("discount_rate") val discountRate: String? = null,
    @SerializedName("discount") val discount: String? = null,
    @SerializedName("gross_value") val grossValue: String? = null,
    @SerializedName("taxable_amount") val taxableAmount: String? = null,
    @SerializedName("tax_amount") val taxAmount: String? = null,
    @SerializedName("total") val total: String? = null,
    @SerializedName("observation") val observation: String? = null,
    @SerializedName("errors") val errors: ArrayList<String> = arrayListOf(),
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("payment_due_date") val paymentDueDate: String? = null,
    @SerializedName("qr_image") val qrImage: String? = null,
    @SerializedName("has_claim") val hasClaim: Int? = null,
    @SerializedName("is_negotiable_instrument") val isNegotiableInstrument: Int? = null,
    @SerializedName("payment_form") val paymentForm: FactusPaymentForm? = FactusPaymentForm(),
    @SerializedName("payment_method") val paymentMethod: FactusPaymentMethod? = FactusPaymentMethod()
)

data class FactusItemsResponse(
    @SerializedName("code_reference") val codeReference: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("quantity") val quantity: Int? = null,
    @SerializedName("discount_rate") val discountRate: String? = null,
    @SerializedName("discount") val discount: String? = null,
    @SerializedName("gross_value") val grossValue: String? = null,
    @SerializedName("tax_rate") val taxRate: String? = null,
    @SerializedName("taxable_amount") val taxableAmount: String? = null,
    @SerializedName("tax_amount") val taxAmount: String? = null,
    @SerializedName("price") val price: String? = null,
    @SerializedName("is_excluded") val isExcluded: Int? = null,
    @SerializedName("unit_measure") val unitMeasure: FactusUnitMeasure? = FactusUnitMeasure(),
    @SerializedName("standard_code") val standardCode: FactusStandardCode? = FactusStandardCode(),
    @SerializedName("tribute") val tribute: FactusTribute? = FactusTribute(),
    @SerializedName("total") val total: Int? = null,
    @SerializedName("withholding_taxes") val withholdingTaxes: ArrayList<FactusWithholdingTaxes> = arrayListOf()
)

data class FactusStandardCode(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("name") val name: String? = null
)

data class FactusUnitMeasure(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("name") val name: String? = null
)

data class FactusDocument(
    @SerializedName("code") val code: String? = null,
    @SerializedName("name") val name: String? = null
)

data class FactusPaymentForm(
    @SerializedName("code") val code: String? = null,
    @SerializedName("name") val name: String? = null
)

data class FactusPaymentMethod(
    @SerializedName("code") val code: String? = null,
    @SerializedName("name") val name: String? = null
)