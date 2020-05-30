package ru.netfantazii.ongoinganimelist.domain.model

import java.time.LocalDate

class JsonTestStrings {
    companion object {
        val correctAiredOnDate: LocalDate = LocalDate.of(2003, 4, 20)
        val correctReleasedOnDate: LocalDate = LocalDate.of(2008, 12, 9)
        const val jsonShortDetailsString = """
{
    "id": 6505,
    "name": "There She Is!!",
    "russian": "А вот и она!",
    "image":{
        "original": "/system/animes/original/6505.jpg?1577456413",
        "preview": "/system/animes/preview/6505.jpg?1577456413",
        "x96": "/system/animes/x96/6505.jpg?1577456413",
        "x48": "/system/animes/x48/6505.jpg?1577456413"
    },
    "url": "/animes/6505-there-she-is",
    "kind": "ona",
    "score": "7.95",
    "status": "released",
    "episodes": 5,
    "episodes_aired": 0,
    "aired_on": "2003-04-20",
    "released_on": "2008-12-09"
}
"""
        const val jsonFullDetailsString = """
{
    "id": 6505,
    "name": "There She Is!!",
    "russian": "А вот и она!",
    "image": {
        "original": "/system/animes/original/6505.jpg?1577456413",
        "preview": "/system/animes/preview/6505.jpg?1577456413",
        "x96": "/system/animes/x96/6505.jpg?1577456413",
        "x48": "/system/animes/x48/6505.jpg?1577456413"
    },
    "url": "/animes/6505-there-she-is",
    "kind": "ona",
    "score": "7.95",
    "status": "released",
    "episodes": 5,
    "episodes_aired": 0,
    "aired_on": "2003-04-20",
    "released_on": "2008-12-09",
    "rating": "g",
    "english": [
        null
    ],
    "japanese": [
        "떳다 그녀!!"
    ],
    "synonyms": [
    ],
    "license_name_ru": null,
    "duration": 5,
    "description": "История разворачивается вокруг крольчихи Докхи, встретившей и полюбившей кота Наби. Общество в этом мире не приемлет отношений между разными видами, и Наби решительно отвергает Докхи. Но любовь всегда найдёт свою дорогу, и видя, как сильны чувства девушки и что она настроена решительно, Наби в конце концов сдаётся и, несмотря на всеобщее осуждение, даёт Докхи шанс, найдя и в ней что-то привлекательное для себя.",
    "description_html": "<div class=\"b-prgrph\">История разворачивается вокруг крольчихи <a href=\"https://shikimori.one/characters/26245-doki\" title=\"Doki\" class=\"bubbled b-link\" data-tooltip_url=\"https://shikimori.one/characters/26245-doki/tooltip\">Докхи</a>, встретившей и полюбившей кота <a href=\"https://shikimori.one/characters/26246-nabi\" title=\"Nabi\" class=\"bubbled b-link\" data-tooltip_url=\"https://shikimori.one/characters/26246-nabi/tooltip\">Наби</a>. Общество в этом мире не приемлет отношений между разными видами, и <a href=\"https://shikimori.one/characters/26246-nabi\" title=\"Nabi\" class=\"bubbled b-link\" data-tooltip_url=\"https://shikimori.one/characters/26246-nabi/tooltip\">Наби</a> решительно отвергает <a href=\"https://shikimori.one/characters/26245-doki\" title=\"Doki\" class=\"bubbled b-link\" data-tooltip_url=\"https://shikimori.one/characters/26245-doki/tooltip\">Докхи</a>. Но любовь всегда найдёт свою дорогу, и видя, как сильны чувства девушки и что она настроена решительно, <a href=\"https://shikimori.one/characters/26246-nabi\" title=\"Nabi\" class=\"bubbled b-link\" data-tooltip_url=\"https://shikimori.one/characters/26246-nabi/tooltip\">Наби</a> в конце концов сдаётся и, несмотря на всеобщее осуждение, даёт <a href=\"https://shikimori.one/characters/26245-doki\" title=\"Doki\" class=\"bubbled b-link\" data-tooltip_url=\"https://shikimori.one/characters/26245-doki/tooltip\">Докхи</a> шанс, найдя и в ней что-то привлекательное для себя.</div>",
    "description_source": null,
    "franchise": null,
    "favoured": false,
    "anons": false,
    "ongoing": false,
    "thread_id": 3903,
    "topic_id": 3903,
    "myanimelist_id": 6505,
    "rates_scores_stats": [
        {
            "name": 10,
            "value": 142
        },
        {
            "name": 9,
            "value": 91
        },
        {
            "name": 8,
            "value": 137
        },
        {
            "name": 7,
            "value": 112
        },
        {
            "name": 6,
            "value": 51
        },
        {
            "name": 5,
            "value": 32
        },
        {
            "name": 4,
            "value": 12
        },
        {
            "name": 3,
            "value": 5
        },
        {
            "name": 2,
            "value": 3
        },
        {
            "name": 1,
            "value": 5
        }
    ],
    "rates_statuses_stats": [
        {
            "name": "Просмотрено",
            "value": 1082
        },
        {
            "name": "Брошено",
            "value": 65
        },
        {
            "name": "Отложено",
            "value": 25
        },
        {
            "name": "Запланировано",
            "value": 614
        },
        {
            "name": "Смотрю",
            "value": 18
        }
    ],
    "updated_at": "2020-05-26T21:23:06.587+03:00",
    "next_episode_at": null,
    "genres": [
        {
            "id": 4,
            "name": "Comedy",
            "russian": "Комедия",
            "kind": "anime"
        },
        {
            "id": 22,
            "name": "Romance",
            "russian": "Романтика",
            "kind": "anime"
        }
    ],
    "studios": [
        {
            "id": 341,
            "name": "SamBakZa",
            "filtered_name": "SamBakZa",
            "real": false,
            "image": null
        }
    ],
    "videos": [
    ],
    "screenshots": [
        {
            "original": "/system/screenshots/original/54032cb9ad90f8b7fa540d8b534121be61fc265d.jpg?1561802168",
            "preview": "/system/screenshots/x332/54032cb9ad90f8b7fa540d8b534121be61fc265d.jpg?1561802168"
        },
        {
            "original": "/system/screenshots/original/3e4e3b101a0c32e46fe3769da67dac88f5349dac.jpg?1561802169",
            "preview": "/system/screenshots/x332/3e4e3b101a0c32e46fe3769da67dac88f5349dac.jpg?1561802169"
        }
    ],
    "user_rate": null
}
"""
    }
}