package com.rlinoz.modulo3_estrutura_de_dados.conjuntos


data class Student(val name: String)

data class Course(
    val name: String,
    val professor: String,
    val students: Set<Student>
) {
    override fun toString(): String {
        return students.map { it.name }.joinToString(",")
    }
}

fun main() {
    val java = Course(
        name = "Java",
        professor = "David",
        students = setOf(
            Student("Beatriz"),
            Student("Fernando"),
            Student("Marcelo"),
            Student("Luiz")
        )
    )

    val kotlin = Course(
        name = "Kotlin",
        professor = "Pedro",
        students = setOf(
            Student("Beatriz"),
            Student("Fernando"),
            Student("Ana"),
            Student("Pedro")
        )
    )

    val lisp = Course(
        name = "Lisp",
        professor = "Hilda",
        students = setOf(
            Student("Fernando"),
        )
    )

    // Qual o nome de todos os estudantes?
    val allStudents: Set<Student> = java.students + kotlin.students + lisp.students
    println(allStudents) // união

    // Existe um aluno que chama Pedro? // O(1)
    println(allStudents.contains(Student("Pedro")))

    allStudents.forEach { print("$it ") }
    println()

    // interseção e diferença

    // Quais alunos cursam kotlin, mas não java?
    println(kotlin.students - java.students)

    // Quem faz kotlin e java?
    val javaAndKotlin = kotlin.students intersect java.students
    println(javaAndKotlin)

    // Quem cursa todos os cursos?
    println(kotlin.students intersect java.students intersect lisp.students)

    // Todo mundo que cursa kotlin e java, mas não cursa os dois
    val kotlinOnly = kotlin.students - javaAndKotlin
    val javaOnly = java.students - javaAndKotlin
    println(kotlinOnly + javaOnly)
}