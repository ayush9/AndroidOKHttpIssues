package com.example.androidokhttpissues

const val HTTP_ISSUES_SUCCESS_RESPONSE = "{\n" +
        "\t\"url\": \"https://api.github.com/repos/square/okhttp/issues/6800\",\n" +
        "\t\"repository_url\": \"https://api.github.com/repos/square/okhttp\",\n" +
        "\t\"labels_url\": \"https://api.github.com/repos/square/okhttp/issues/6800/labels{/name}\",\n" +
        "\t\"comments_url\": \"https://api.github.com/repos/square/okhttp/issues/6800/comments\",\n" +
        "\t\"events_url\": \"https://api.github.com/repos/square/okhttp/issues/6800/events\",\n" +
        "\t\"html_url\": \"https://github.com/square/okhttp/pull/6800\",\n" +
        "\t\"id\": 957201430,\n" +
        "\t\"node_id\": \"MDExOlB1bGxSZXF1ZXN0NzAwNjc2NTg1\",\n" +
        "\t\"number\": 6800,\n" +
        "\t\"title\": \"Envoy Mobile experiment\",\n" +
        "\t\"user\": {\n" +
        "\t\t\"login\": \"yschimke\",\n" +
        "\t\t\"id\": 231923,\n" +
        "\t\t\"node_id\": \"MDQ6VXNlcjIzMTkyMw==\",\n" +
        "\t\t\"avatar_url\": \"https://avatars.githubusercontent.com/u/231923?v=4\",\n" +
        "\t\t\"gravatar_id\": \"\",\n" +
        "\t\t\"url\": \"https://api.github.com/users/yschimke\",\n" +
        "\t\t\"html_url\": \"https://github.com/yschimke\",\n" +
        "\t\t\"followers_url\": \"https://api.github.com/users/yschimke/followers\",\n" +
        "\t\t\"following_url\": \"https://api.github.com/users/yschimke/following{/other_user}\",\n" +
        "\t\t\"gists_url\": \"https://api.github.com/users/yschimke/gists{/gist_id}\",\n" +
        "\t\t\"starred_url\": \"https://api.github.com/users/yschimke/starred{/owner}{/repo}\",\n" +
        "\t\t\"subscriptions_url\": \"https://api.github.com/users/yschimke/subscriptions\",\n" +
        "\t\t\"organizations_url\": \"https://api.github.com/users/yschimke/orgs\",\n" +
        "\t\t\"repos_url\": \"https://api.github.com/users/yschimke/repos\",\n" +
        "\t\t\"events_url\": \"https://api.github.com/users/yschimke/events{/privacy}\",\n" +
        "\t\t\"received_events_url\": \"https://api.github.com/users/yschimke/received_events\",\n" +
        "\t\t\"type\": \"User\",\n" +
        "\t\t\"site_admin\": false\n" +
        "\t},\n" +
        "\t\"labels\": [{\n" +
        "\t\t\"id\": 3189973233,\n" +
        "\t\t\"node_id\": \"MDU6TGFiZWwzMTg5OTczMjMz\",\n" +
        "\t\t\"url\": \"https://api.github.com/repos/square/okhttp/labels/android-regression\",\n" +
        "\t\t\"name\": \"android-regression\",\n" +
        "\t\t\"color\": \"e99695\",\n" +
        "\t\t\"default\": false,\n" +
        "\t\t\"description\": \"Run a PR against regression tests\"\n" +
        "\t}],\n" +
        "\t\"state\": \"open\",\n" +
        "\t\"locked\": false,\n" +
        "\t\"assignee\": null,\n" +
        "\t\"assignees\": [],\n" +
        "\t\"milestone\": null,\n" +
        "\t\"comments\": 1,\n" +
        "\t\"created_at\": \"2021-07-31T08:31:08Z\",\n" +
        "\t\"updated_at\": \"2021-07-31T08:34:51Z\",\n" +
        "\t\"closed_at\": null,\n" +
        "\t\"author_association\": \"COLLABORATOR\",\n" +
        "\t\"active_lock_reason\": null,\n" +
        "\t\"pull_request\": {\n" +
        "\t\t\"url\": \"https://api.github.com/repos/square/okhttp/pulls/6800\",\n" +
        "\t\t\"html_url\": \"https://github.com/square/okhttp/pull/6800\",\n" +
        "\t\t\"diff_url\": \"https://github.com/square/okhttp/pull/6800.diff\",\n" +
        "\t\t\"patch_url\": \"https://github.com/square/okhttp/pull/6800.patch\"\n" +
        "\t},\n" +
        "\t\"body\": \"Quic prototype of the code to bridge between OkHttp and EnvoyMobile\\r\\n\\r\\nBlocked on binary aar dependency https://github.com/envoyproxy/envoy-mobile/issues/1651\\r\\n\\r\\nAlso only runs on SDK 24 and x86.  aar does not include other platforms and isn't working on recent Android versions.\",\n" +
        "\t\"performed_via_github_app\": null\n" +
        "}"
const val HTTP_ISSUES_FAILURE_RESPONSE = ""