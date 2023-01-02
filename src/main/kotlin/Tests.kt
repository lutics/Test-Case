import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoUnit
import kotlin.math.abs

fun main(args: Array<String>) {
//    val answer = solution(intArrayOf(2, 6, 8, 5))
//    val answer = solution(intArrayOf(1, 1))
//    val answer = solution(intArrayOf(1, 5, 5, 2, 6))
//    println(answer)

//    val answer = solution("123-adb-123")
//    println(answer)

//    val answer = solution1(10)
//    println(answer.contentToString())

//    val v = arrayOf(intArrayOf(1, 4), intArrayOf(3, 4), intArrayOf(3, 10))
//    val v = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(1, 2))
//    val answer = solution2(v)
//    println(answer.contentToString())

//    solution3("010-1212-333")

//    println(solution4("brbabrrara"))

//    println(solution5("2019/12/01 SUN", "2020/03/02", arrayOf("01/02", "12/24", "03/01")))

//    println(solution6(15))

//    solution("AyA", "AxA")

//    val board = arrayOf(intArrayOf(1, -7, -2, 1, -1), intArrayOf(2, 3, 0, -1, -2), intArrayOf(1, -1, 6, -1, -2), intArrayOf(-1, 1, -2, 0, 4), intArrayOf(-10, 5, -3, -1, 1))
    val board = arrayOf(intArrayOf(-10, 20, 30), intArrayOf(-10, 0, 10), intArrayOf(-20, 40, 1))
    solution(board)
}

/**
 *
 */
fun solution(board: Array<IntArray>): Int {
    var answer: Int = 0

    var y = 0
    var x = 0

    while (y < board.size && x < board.size) {
        val current = board[y][x]

        if (current == 0) {
            answer = abs(answer)
        } else {
            answer += current
        }

        println("$y, $x, ${current}, $answer")

        val right = board[y][x + 1]
        val down = board[y + 1][x]

        val whenMoveRight = abs(answer + right)
        val whenMoveDown = abs(answer + down)

        if (whenMoveDown > whenMoveRight) {
            y += 1
        } else {
            x += 1
        }
    }

    println(answer)

    return answer
}

//fun solution(numbers: IntArray): Int {
//    var answer = -1
//
//    val sorted = numbers.sorted()
//
//    var converted: List<Int> = if (sorted.size > 2) {
//        val temp = IntArray(sorted.size / 2)
//
//        for (i in 0 until sorted.size / 2) {
//            val a = sorted[i]
//            val b = sorted[sorted.lastIndex - i]
//
//            temp[i] = a + b
//        }
//
//        temp.toList()
//    } else {
//        sorted
//    }
//
//    var sum = 0
//    for (i in 0..converted.size) {
//        if (i + 1 < converted.size) {
//            val gap = abs(converted[i] - converted[i + 1])
//
//            sum += gap
//        }
//    }
//
//    answer = sum
//
//    return answer
//}

/**
 *
 */
//fun solution(s1: String, s2: String): String {
//    var s1Result = ""
//    var s2Result = ""
//
//    for (i in 1 until s1.length) {
//        val delimiter = s1.takeLast(i)
//
//        if (s2.startsWith(delimiter)) {
//            s1Result = s1.dropLast(i) + s2
//        }
//    }
//
//    for (i in 1 until s2.length) {
//        val delimiter = s2.takeLast(i)
//
//        if (s1.startsWith(delimiter)) {
//            s2Result = s2.dropLast(i) + s1
//        }
//    }
//
//    val answer = when {
//        s1Result.length == s2Result.length -> if (s1Result.compareTo(s2Result) < 0) s1Result else s2Result
//        s1Result.length < s2Result.length -> s1Result
//        else -> s2Result
//    }
//
//    return answer
//}

/**
 * IntArray 받고 어떤 위치에서 출발했던 가장 멀리 잡을 수 있는 길이 (실패)
 */
//fun solution(blocks: IntArray): Int {
//    // write your code in Kotlin 1.6.0 (Linux)
//    var answer = 0
//
//    blocks.forEachIndexed { index, i ->
//        // Init Position
//        var minIdx = i
//        var maxIdx = i
//
//        // lIdx
//        for (lPosition in index downTo 0) {
//            if (lPosition - 1 >= 0) {
//                val prevValue = blocks[lPosition - 1]
//                if (minIdx >= prevValue) {
//                    minIdx = prevValue
//                } else {
//                    break
//                }
//            }
//        }
//
//        // rIdx
//        for (rPosition in index until blocks.size) {
//            if (rPosition + 1 < blocks.size) {
//                val nextValue = blocks[rPosition + 1]
//                if (maxIdx <= nextValue) {
//                    maxIdx = nextValue
//                } else {
//                    break
//                }
//            }
//        }
//
//        val lIdx = blocks.indexOf(minIdx)
//        val rIdx = blocks.indexOf(maxIdx)
//
//        val range = blocks.copyOfRange(lIdx, rIdx)
//
//        val result = range.size
//
//        if (answer < result) {
//            answer = result
//        }
//    }
//
//    return answer
//}

/**
 * 스트링 받고 3-3-3 자의 숫자만 포함되어 있는지
 */
//fun solution(S: String): Boolean {
//    // write your code in Kotlin 1.6.0 (Linux)
//
//    val regex = "\\d{3}[-\\]]\\d{3}[-\\]]\\d{3}".toRegex()
//
//    return S.matches(regex)
//}

/**
 * 폰넘버 받고 주소록에 들어 있는지 찾기, 없으면 그대로 번호 반환
 */
//fun solution(phone_numbers: Array<String>, phone_owners: Array<String>, number: String): String {
//    // write your code in Kotlin 1.6.0 (Linux)
//
//    val idx = phone_numbers.indexOf(number)
//    if (idx != -1) {
//        return phone_owners[idx]
//    } else {
//        return number
//    }
//}

/**
 * 숫자 입력받고 글자로 다 이어 붙인다음, 해당 번째의 글씨 반환
 */
fun solution6(n: Int): Int {
    var answer: Int = -1

    var temp = ""

    for (i in 0..n) {
        temp += "$i"
    }

    println(temp)

    answer = Integer.parseInt(temp[n].toString())

    return answer
}

/**
 * 날짜 주어지면 일한 일 수 구하기, 윤년 빼고
 */
fun solution5(join_date: String, resign_date: String, holidays: Array<String>): Int {
    var answer: Int = 0

    val formatter1 = DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("yyyy/MM/dd EEE").toFormatter()
    val formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd")

    val joinDate = LocalDate.parse(join_date, formatter1)
    val resignDate = LocalDate.parse(resign_date, formatter2)

    val joinDateYear = joinDate.year
    val resignDateYear = resignDate.year

    val isJoinDateYearIsLunarYear = joinDateYear % 4 == 0 && joinDateYear % 100 != 0 || joinDateYear % 400 == 0
    val isResignDateYearIsLunarYear = resignDateYear % 4 == 0 && resignDateYear % 100 != 0 || resignDateYear % 400 == 0

    var lunarCnt = 0
    if (joinDate.monthValue >= 2 && isJoinDateYearIsLunarYear) lunarCnt += 1
    if (resignDate.monthValue >= 2 && isResignDateYearIsLunarYear) lunarCnt += 1

    val weeks = ChronoUnit.WEEKS.between(joinDate, resignDate).toInt()
    val weekends = weeks * 2
    val days = ChronoUnit.DAYS.between(joinDate, resignDate).toInt()

    if (resignDate.equals(joinDate)) {
        answer = 1
    } else {
        answer = days - weekends - holidays.size + lunarCnt
    }

    return answer
}

/**
 * 문자열을 받고 2번째로 많은 단어, 2번째랑 3번째도 같으면 2, 3번째꺼
 */
fun solution4(s: String): String {
    var answer: String = ""

    val map = mutableMapOf<Char, Int>()

    for (c in s) {
        map.putIfAbsent(c, 0)
        map[c] = map[c]!! + 1
    }

    val list = map.toList()

    val sorted = list.sortedBy { it.second }

    answer = when {
        sorted.size == 1 || sorted.size == 2 -> "-"
        else -> {
            var reversed = sorted.reversed()

            if (reversed[0].second == reversed[1].second) {
                reversed = reversed.drop(1)
            }

            val removedFirstElement = reversed.drop(1)

            if (removedFirstElement[0].second == removedFirstElement[1].second) {
                removedFirstElement.map { it.first }.joinToString(separator = "")
            } else {
                removedFirstElement.first().first.toString()
            }
        }
    }

    return answer
}

/**
 * 스트링을 받아 폰번호 패턴 반환
 */
fun solution3(phone_number: String): Int {
    var answer = 0

    answer = when {
        phone_number.startsWith("+82") && phone_number.split("-")[1].startsWith("1") -> 3
        phone_number.contains("-") && phone_number.split("-").size == 3 && phone_number.split("-").last().length == 4 -> 1
        phone_number.length == 11 -> 2
        else -> -1
    }

    return answer
}

/**
 * 3개의 배열을 받아 직사각형의 나머지 좌표 찾기
 */
fun solution2(v: Array<IntArray>): IntArray {
    return intArrayOf(
        v[0][0].xor(v[1][0].xor(v[2][0])),
        v[0][1].xor(v[1][1].xor(v[2][1]))
    )
}

/**
 * 정수 n 이 주어질 때 정수를 순서대로 담은 배열
 */
fun solution1(n: Int): IntArray {
    val answer = IntArray(n) { it + 1 }

    return answer
}
