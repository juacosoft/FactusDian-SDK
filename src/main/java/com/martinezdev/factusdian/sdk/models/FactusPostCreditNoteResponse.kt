package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusPostCreditNoteResponse(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: FactusPostCreditNoteDataResponse
)

data class FactusPostCreditNoteDataResponse(
    @SerializedName("company") val company: FactusPostCreditNoteCompanyResponse,
    @SerializedName("customer") val customer: FactusPostCreditNoteCustomerResponse,
    @SerializedName("credit_note") val creditNote: FactusPostCreditNoteCreditNoteResponse,
    @SerializedName("items") val items: List<FactusPostCreditNoteItemResponse>,
    @SerializedName("withholding_taxes") val withholdingTaxes: List<Any>?
)

data class FactusPostCreditNoteCompanyResponse(
    @SerializedName("url_logo") val urlLogo: String,
    @SerializedName("nit") val nit: String,
    @SerializedName("dv") val dv: String,
    @SerializedName("company") val company: String,
    @SerializedName("name") val name: String,
    @SerializedName("registration_code") val registrationCode: String,
    @SerializedName("economic_activity") val economicActivity: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("email") val email: String,
    @SerializedName("direction") val direction: String,
    @SerializedName("municipality") val municipality: String
)

data class FactusPostCreditNoteCustomerResponse(
    @SerializedName("identification") val identification: String,
    @SerializedName("dv") val dv: String?,
    @SerializedName("graphic_representation_name") val graphicRepresentationName: String,
    @SerializedName("trade_name") val tradeName: String?,
    @SerializedName("company") val company: String,
    @SerializedName("names") val names: String,
    @SerializedName("address") val address: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("legal_organization") val legalOrganization: FactusPostCreditNoteLegalOrganizationResponse,
    @SerializedName("tribute") val tribute: FactusPostCreditNoteTributeResponse,
    @SerializedName("municipality") val municipality: List<Any>
)

data class FactusPostCreditNoteLegalOrganizationResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusPostCreditNoteTributeResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusPostCreditNoteCreditNoteResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("number") val number: String,
    @SerializedName("reference_code") val referenceCode: String,
    @SerializedName("status") val status: Int,
    @SerializedName("send_email") val sendEmail: Int,
    @SerializedName("qr") val qr: String,
    @SerializedName("cude") val cude: String,
    @SerializedName("validated") val validated: String,
    @SerializedName("discount_rate") val discountRate: String,
    @SerializedName("discount") val discount: String,
    @SerializedName("gross_value") val grossValue: String,
    @SerializedName("taxable_amount") val taxableAmount: String,
    @SerializedName("tax_amount") val taxAmount: String,
    @SerializedName("total") val total: String,
    @SerializedName("observation") val observation: String?,
    @SerializedName("errors") val errors: List<String>,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("qr_image") val qrImage: String,
    @SerializedName("bill_id") val billId: Int,
    @SerializedName("cufe") val cufe: String,
    @SerializedName("number_bill") val numberBill: String,
    @SerializedName("payment_method") val paymentMethod: FactusPostCreditNotePaymentMethodResponse,
    @SerializedName("customization_id") val customizationId: FactusPostCreditNoteCustomizationIdResponse,
    @SerializedName("correction_concept") val correctionConcept: CorrectionConcept
)

data class FactusPostCreditNotePaymentMethodResponse(
    @SerializedName("name") val name: String,
    @SerializedName("code") val code: String
)

data class FactusPostCreditNoteCustomizationIdResponse(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class CorrectionConcept(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusPostCreditNoteItemResponse(
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
    @SerializedName("unit_measure") val unitMeasure: FactusPostCreditNoteUnitMeasureResponse,
    @SerializedName("standard_code") val standardCode: FactusPostCreditNoteStandardCodeResponse,
    @SerializedName("tribute") val tribute: FactusPostCreditNoteTributeResponse,
    @SerializedName("total") val total: Int,
    @SerializedName("withholding_taxes") val withholdingTaxes: List<Any>
)

data class FactusPostCreditNoteUnitMeasureResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)

data class FactusPostCreditNoteStandardCodeResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String
)
