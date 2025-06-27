<template>

    <v-card outlined>
        <v-card-title>
            Accept
        </v-card-title>

        <v-card-text>
            <Number label="ClaimId" v-model="value.claimId" :editMode="editMode"/>
            <Boolean label="AcceptYn" v-model="value.acceptYn" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="accept"
            >
                Accept
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'AcceptCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.claimId = 0;
        this.value.acceptYn = false;
    },
    watch: {
    },
    methods: {
        accept() {
            this.$emit('accept', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

