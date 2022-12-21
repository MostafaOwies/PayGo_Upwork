package com.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.core.data.data.action.dao.ActionDao
import com.core.data.data.address.dao.AddressDao
import com.core.data.data.booking.dao.BookingDao
import com.core.data.data.category.dao.CategoryDao
import com.core.data.data.discount.dao.DiscountDao
import com.core.data.data.favorites.dao.FavoritesDao
import com.core.data.data.messagenetwork.dao.MessageNetworkDao
import com.core.data.data.money.dao.MoneyDao
import com.core.data.data.offer.dao.OfferDao
import com.core.data.data.offerset.dao.OfferSetDao
import com.core.data.data.order.dao.OrderDao
import com.core.data.data.orderfinance.dao.OrderFinanceDao
import com.core.data.data.orderproduct.dao.OrderProductDao
import com.core.data.data.orderproductstatus.dao.OrderProductStatusDao
import com.core.data.data.orderstatus.dao.OrderStatusDao
import com.core.data.data.paymentintegration.dao.PaymentIntegrationDao
import com.core.data.data.permission.dao.PermissionDao
import com.core.data.data.product.dao.ProductDao
import com.core.data.data.retailer.dao.RetailerDao
import com.core.data.data.retailerpaymentdetails.dao.RetailerPaymentDetailsDao
import com.core.data.data.ros.dao.RosDao
import com.core.data.data.slot.dao.SlotDao
import com.core.data.data.subproduct.dao.SubProductDao
import com.core.data.data.subproducttype.dao.SubProductTypeDao
import com.core.data.data.user.dao.UserDao
import com.core.domain.entities.*
import com.core.domain.entities.category.Category
import com.core.domain.relations.manytomany.orderproductwithofferset.OrderProductWithOfferSetCrossRef
import com.core.domain.relations.manytomany.orderproductwithsubproduct.OrderProductWithSubProductCrossRef

@Database(
    entities = [
        Action::class,
        Address::class,
        Booking::class,
        Category::class,
        Discount::class,
        Favorites::class,
        MessageNetwork::class,
        Money::class,
        Offer::class,
        OfferSet::class,
        Order::class,
        OrderFinance::class,
        OrderProduct::class,
        OrderProductStatus::class,
        OrderStatus::class,
        PaymentIntegration::class,
        Permission::class,
        Product::class,
        Retailer::class,
        RetailerPaymentDetails::class,
        ROS::class,
        Slot::class,
        SubProduct::class,
        SubProductType::class,
        User::class,
        OrderProductWithOfferSetCrossRef::class,
        OrderProductWithSubProductCrossRef::class,
    ],
    version = 10
)
@TypeConverters(Converters::class)
abstract class PayGoDatabase : RoomDatabase() {

    abstract fun getAddressDao(): AddressDao
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getDiscountDao(): DiscountDao
    abstract fun getFavoritesDao(): FavoritesDao
    abstract fun getMessageNetworkDao(): MessageNetworkDao
    abstract fun getMoneyDao(): MoneyDao
    abstract fun getOfferDao(): OfferDao
    abstract fun getOfferSetDao(): OfferSetDao
    abstract fun getOrderDao(): OrderDao
    abstract fun getOrderFinanceDao(): OrderFinanceDao
    abstract fun getOrderProductDao(): OrderProductDao
    abstract fun getOrderProductStatusDao(): OrderProductStatusDao
    abstract fun getOrderStatusDao(): OrderStatusDao
    abstract fun getPaymentIntegrationDao(): PaymentIntegrationDao
    abstract fun getPermissionDao(): PermissionDao
    abstract fun getProductDao(): ProductDao
    abstract fun getRetailerDao(): RetailerDao
    abstract fun getRetailerPaymentDetailsDao(): RetailerPaymentDetailsDao
    abstract fun getROSDao(): RosDao
    abstract fun getSlotDao(): SlotDao
    abstract fun getSubProductDao(): SubProductDao
    abstract fun getSubProductTypeDao(): SubProductTypeDao
    abstract fun getUserDao(): UserDao
    abstract fun getActionDao(): ActionDao
    abstract fun getBookingDao(): BookingDao


}