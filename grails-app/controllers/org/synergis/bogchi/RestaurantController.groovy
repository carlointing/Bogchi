package org.synergis.bogchi

class RestaurantController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [restaurantInstanceList: Restaurant.list(params), restaurantInstanceTotal: Restaurant.count()]
    }

    def create = {
        def restaurantInstance = new Restaurant()
        restaurantInstance.properties = params
        return [restaurantInstance: restaurantInstance]
    }

    def save = {
        def restaurantInstance = new Restaurant(params)
        if (restaurantInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'restaurant.label', default: 'Restaurant'), restaurantInstance.id])}"
            redirect(action: "show", id: restaurantInstance.id)
        }
        else {
            render(view: "create", model: [restaurantInstance: restaurantInstance])
        }
    }

    def show = {
        def restaurantInstance = Restaurant.get(params.id)
        if (!restaurantInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'restaurant.label', default: 'Restaurant'), params.id])}"
            redirect(action: "list")
        }
        else {
            [restaurantInstance: restaurantInstance]
        }
    }

    def edit = {
        def restaurantInstance = Restaurant.get(params.id)
        if (!restaurantInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'restaurant.label', default: 'Restaurant'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [restaurantInstance: restaurantInstance]
        }
    }

    def update = {
        def restaurantInstance = Restaurant.get(params.id)
        if (restaurantInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (restaurantInstance.version > version) {
                    
                    restaurantInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'restaurant.label', default: 'Restaurant')] as Object[], "Another user has updated this Restaurant while you were editing")
                    render(view: "edit", model: [restaurantInstance: restaurantInstance])
                    return
                }
            }
            restaurantInstance.properties = params
            if (!restaurantInstance.hasErrors() && restaurantInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'restaurant.label', default: 'Restaurant'), restaurantInstance.id])}"
                redirect(action: "show", id: restaurantInstance.id)
            }
            else {
                render(view: "edit", model: [restaurantInstance: restaurantInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'restaurant.label', default: 'Restaurant'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def restaurantInstance = Restaurant.get(params.id)
        if (restaurantInstance) {
            try {
                restaurantInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'restaurant.label', default: 'Restaurant'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'restaurant.label', default: 'Restaurant'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'restaurant.label', default: 'Restaurant'), params.id])}"
            redirect(action: "list")
        }
    }
}
