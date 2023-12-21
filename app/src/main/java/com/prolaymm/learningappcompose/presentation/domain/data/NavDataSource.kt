package com.prolaymm.learningappcompose.presentation.domain.data

import com.prolaymm.learningappcompose.presentation.domain.vos.CourseVo

object NavDataSource {

    var courseVo: CourseVo? = null

    fun addCourseVo(data : CourseVo) {
        courseVo = data
    }
}