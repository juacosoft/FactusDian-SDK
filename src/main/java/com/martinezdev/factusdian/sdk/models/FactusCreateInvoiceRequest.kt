package com.martinezdev.factusdian.sdk.models

import com.google.gson.annotations.SerializedName

data class FactusCreateInvoiceRequest(
    @SerializedName("numbering_range_id"  ) val numberingRangeId  : Int?             = null,
    @SerializedName("reference_code"      ) val referenceCode     : String?          = null,
    @SerializedName("observation"         ) val observation       : String?          = null,
    @SerializedName("payment_form"        ) val paymentForm       : String?          = null,
    @SerializedName("payment_due_date"    ) val paymentDueDate    : String?          = null,
    @SerializedName("payment_method_code" ) val paymentMethodCode : String?          = null,
    @SerializedName("billing_period"      ) val billingPeriod     : FactusBillingPeriod?   = FactusBillingPeriod(),
    @SerializedName("customer"            ) val customer          : FactusCustomer?        = FactusCustomer(),
    @SerializedName("items"               ) val items             : ArrayList<FactusRequestItems> = arrayListOf()
)

data class FactusBillingPeriod (

    @SerializedName("start_date" ) val startDate : String? = null,
    @SerializedName("start_time" ) val startTime : String? = null,
    @SerializedName("end_date"   ) val endDate   : String? = null,
    @SerializedName("end_time"   ) val endTime   : String? = null

)

data class FactusCustomer (
    @SerializedName("identification"             ) val identification           : String? = null,
    @SerializedName("dv"                         ) val dv                       : String? = null,
    @SerializedName("company"                    ) val company                  : String? = null,
    @SerializedName("trade_name"                 ) val tradeName                : String? = null,
    @SerializedName("names"                      ) val names                    : String? = null,
    @SerializedName("address"                    ) val address                  : String? = null,
    @SerializedName("email"                      ) val email                    : String? = null,
    @SerializedName("phone"                      ) val phone                    : String? = null,
    @SerializedName("legal_organization_id"      ) val legalOrganizationId      : String? = null,
    @SerializedName("tribute_id"                 ) val tributeId                : String? = null,
    @SerializedName("identification_document_id" ) val identificationDocumentId : String? = null,
    @SerializedName("municipality_id"            ) val municipalityId           : String? = null
)

data class FactusWithholdingTaxes (
    @SerializedName("code"                 ) val code               : String? = null,
    @SerializedName("withholding_tax_rate" ) val withholdingTaxRate : String? = null
)

data class FactusRequestItems (
    @SerializedName("code_reference"    ) val codeReference    : String?                     = null,
    @SerializedName("name"              ) val name             : String?                     = null,
    @SerializedName("quantity"          ) val quantity         : Int?                        = null,
    @SerializedName("discount_rate"     ) val discountRate     : Int?                        = null,
    @SerializedName("price"             ) val price            : Int?                        = null,
    @SerializedName("tax_rate"          ) val taxRate          : String?                     = null,
    @SerializedName("unit_measure_id"   ) val unitMeasureId    : Int?                        = null,
    @SerializedName("standard_code_id"  ) val standardCodeId   : Int?                        = null,
    @SerializedName("is_excluded"       ) val isExcluded       : Int?                        = null,
    @SerializedName("tribute_id"        ) val tributeId        : Int?                        = null,
    @SerializedName("withholding_taxes" ) val withholdingTaxes : ArrayList<FactusWithholdingTaxes> = arrayListOf()
)
