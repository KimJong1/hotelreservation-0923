<template>

    <v-data-table
        :headers="headers"
        :items="userpage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'UserpageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "roomId", value: "roomId" },
                { text: "status", value: "status" },
                { text: "reservationId", value: "reservationId" },
            ],
            userpage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/userpages'))

            temp.data._embedded.userpages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.userpage = temp.data._embedded.userpages;
        },
        methods: {
        }
    }
</script>

