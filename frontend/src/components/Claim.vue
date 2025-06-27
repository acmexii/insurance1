<template>
    <div>
        <String
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <String
            label="ClaimTitle"
            v-model="value.claimTitle"
            :editMode="editMode"
        />
        <Date
            label="AcceptDate"
            v-model="value.acceptDate"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Claim',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "claims",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
