package com.prolaymm.learningappcompose.presentation.domain.vos

import com.google.gson.annotations.SerializedName


data class CourseVo (
    @SerializedName("_class"                  ) var Class                : String?                       = null,
    @SerializedName("id"                      ) var id                   : Int?                          = null,
    @SerializedName("title"                   ) var title                : String?                       = null,
    @SerializedName("url"                     ) var url                  : String?                       = null,
    @SerializedName("is_paid"                 ) var isPaid               : Boolean?                      = null,
    @SerializedName("price"                   ) var price                : String?                       = null,
    @SerializedName("price_detail"            ) var priceDetail          : String?                       = null,
    @SerializedName("price_serve_tracking_id" ) var priceServeTrackingId : String?                       = null,
    @SerializedName("visible_instructors"     ) var visibleInstructors   : ArrayList<VisibleInstructors> = arrayListOf(),
    @SerializedName("image_125_H"             ) var image125H            : String?                       = null,
    @SerializedName("image_240x135"           ) var image240x135         : String?                       = null,
    @SerializedName("is_practice_test_course" ) var isPracticeTestCourse : Boolean?                      = null,
    @SerializedName("image_480x270"           ) var image480x270         : String?                       = null,
    @SerializedName("published_title"         ) var publishedTitle       : String?                       = null,
    @SerializedName("tracking_id"             ) var trackingId           : String?                       = null,
    @SerializedName("locale"                  ) var supportLocale               : SupportLocale?                       = SupportLocale(),
    @SerializedName("predictive_score"        ) var predictiveScore      : String?                       = null,
    @SerializedName("relevancy_score"         ) var relevancyScore       : String?                       = null,
    @SerializedName("input_features"          ) var inputFeatures        : String?                       = null,
    @SerializedName("lecture_search_result"   ) var lectureSearchResult  : String?                       = null,
    @SerializedName("curriculum_lectures"     ) var curriculumLectures   : ArrayList<String>             = arrayListOf(),
    @SerializedName("order_in_results"        ) var orderInResults       : String?                       = null,
    @SerializedName("curriculum_items"        ) var curriculumItems      : ArrayList<String>             = arrayListOf(),
    @SerializedName("headline"                ) var headline             : String?                       = null,
    @SerializedName("instructor_name"         ) var instructorName       : String?                       = null

)

data class VisibleInstructors (
    @SerializedName("_class"        ) var Class        : String? = null,
    @SerializedName("id"            ) var id           : Int?    = null,
    @SerializedName("title"         ) var title        : String? = null,
    @SerializedName("name"          ) var name         : String? = null,
    @SerializedName("display_name"  ) var displayName  : String? = null,
    @SerializedName("job_title"     ) var jobTitle     : String? = null,
    @SerializedName("image_50x50"   ) var image50x50   : String? = null,
    @SerializedName("image_100x100" ) var image100x100 : String? = null,
    @SerializedName("initials"      ) var initials     : String? = null,
    @SerializedName("url"           ) var url          : String? = null

)
data class SupportLocale (

    @SerializedName("_class"               ) var Class              : String? = null,
    @SerializedName("locale"               ) var locale             : String? = null,
    @SerializedName("title"                ) var title              : String? = null,
    @SerializedName("english_title"        ) var englishTitle       : String? = null,
    @SerializedName("simple_english_title" ) var simpleEnglishTitle : String? = null

)