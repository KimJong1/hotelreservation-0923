
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ReservationReservationManager from "./components/listers/ReservationReservationCards"
import ReservationReservationDetail from "./components/listers/ReservationReservationDetail"

import HotelHotelManager from "./components/listers/HotelHotelCards"
import HotelHotelDetail from "./components/listers/HotelHotelDetail"

import RoomRoomManager from "./components/listers/RoomRoomCards"
import RoomRoomDetail from "./components/listers/RoomRoomDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/reservations/reservations',
                name: 'ReservationReservationManager',
                component: ReservationReservationManager
            },
            {
                path: '/reservations/reservations/:id',
                name: 'ReservationReservationDetail',
                component: ReservationReservationDetail
            },

            {
                path: '/hotels/hotels',
                name: 'HotelHotelManager',
                component: HotelHotelManager
            },
            {
                path: '/hotels/hotels/:id',
                name: 'HotelHotelDetail',
                component: HotelHotelDetail
            },

            {
                path: '/rooms/rooms',
                name: 'RoomRoomManager',
                component: RoomRoomManager
            },
            {
                path: '/rooms/rooms/:id',
                name: 'RoomRoomDetail',
                component: RoomRoomDetail
            },




    ]
})
